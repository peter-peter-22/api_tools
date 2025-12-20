import { zodResolver } from '@hookform/resolvers/zod'
import { useForm } from "react-hook-form"
import { createUserBody } from './api/generated/validation/users';
import { createUser } from './api/generated/client/users';
import type { ErrorResponse, UserCreateRequest } from './api/generated/client/openAPIDefinition.schemas';

export default function App() {
  const { register, handleSubmit, formState: { errors }, setError } = useForm<UserCreateRequest>({
    resolver: zodResolver(createUserBody),
  });

  const onSubmit = async (data: UserCreateRequest) => {
    try {
      const user = await createUser(data);
      console.log("Created user:", user);
      alert('User created!');
    } catch (err: any) {
      const res = err.response?.data as ErrorResponse;
      console.log(err);
      if (res) {
        if (res.errors) {
          Object.entries(res.errors).forEach(([field, message]) => {
            setError(field as keyof UserCreateRequest, { message });
          });
        }
      }
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