import { zodResolver } from '@hookform/resolvers/zod'
import { useForm } from "react-hook-form"
import type z from 'zod'
import { ZodError } from 'zod'
import { createApiClient, schemas } from './api/generated/usersApi'

type FormData = z.infer<typeof schemas.UserCreateRequest>

export default function App() {
  const { register, handleSubmit, formState: { errors }, setError } = useForm<FormData>({
    resolver: zodResolver(schemas.UserCreateRequest),
  });

  const api = createApiClient("http://localhost:8080")

  const onSubmit = async (data: FormData) => {
    try {
      const user = await api.createUser(data);
      console.log("Created user:", user);
      alert('User created!');
    } catch (err: any) {
      if (err instanceof ZodError) {
        err.issues.forEach((e) => setError(e.path[0] as any, { message: e.message }));
      } else if (err.response?.data) {
        const serverErr = err.response.data as { errors?: Record<string, string> };
        if (serverErr.errors) {
          Object.entries(serverErr.errors).forEach(([field, message]) => {
            setError(field as keyof FormData, { message });
          });
        }
      }
      else console.error(err)
    }
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
      <div>
        <input {...register('name')} placeholder="Name" className="border p-2 w-full" />
        {errors.name && <p className="text-red-500 text-sm">{errors.name.message}</p>}
      </div>

      <div>
        <input {...register('email')} placeholder="Email" className="border p-2 w-full" />
        {errors.email && <p className="text-red-500 text-sm">{errors.email.message}</p>}
      </div>

      <div>
        <input {...register('age', { valueAsNumber: true })} type="number" placeholder="Age" className="border p-2 w-full" />
        {errors.age && <p className="text-red-500 text-sm">{errors.age.message}</p>}
      </div>

      <button type="submit" className="bg-blue-500 text-white px-4 py-2">Create User</button>
    </form>
  );
}