import { zodResolver } from '@hookform/resolvers/zod';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useState } from 'react';
import { Button, Container, Form, ListGroup, Stack } from 'react-bootstrap';
import { useForm } from "react-hook-form";
import type { ErrorResponse, User, UserCreateRequest } from './api/generated/client/openAPIDefinition.schemas';
import { createUser, getUsers } from './api/generated/client/users';
import { createUserBody } from './api/generated/validation/users';

function UserForm() {
  const { register, handleSubmit, formState: { errors }, setError } = useForm<UserCreateRequest>({
    resolver: zodResolver(createUserBody),
  });

  const onSubmit = async (data: UserCreateRequest) => {
    try {
      const user = await createUser(data);
      console.log("Created user:", user);
      alert("User created");
    } catch (err: any) {
      const res = err.response?.data as ErrorResponse;
      if (res && res.errors) {
        Object.entries(res.errors).forEach(([field, message]) => {
          setError(field as keyof UserCreateRequest, { message });
        });
      }
      else {
        alert(res?.message ?? err.message ?? "Unknown error")
      }
    }
  };

  return (
    <Form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
      <Form.Group className="mb-3">
        <Form.Label>Name</Form.Label>
        <Form.Control {...register('name')} placeholder="Name" isInvalid={!!errors.name} />
        <Form.Control.Feedback type="invalid">
          {errors.name?.message}
        </Form.Control.Feedback>
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Email address</Form.Label>
        <Form.Control {...register('email')} type="email" placeholder="Email" isInvalid={!!errors.email} />
        <Form.Control.Feedback type="invalid">
          {errors.email?.message}
        </Form.Control.Feedback>
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Age</Form.Label>
        <Form.Control {...register('age', { valueAsNumber: true })} type="number" placeholder="Age" isInvalid={!!errors.age} />
        <Form.Control.Feedback type="invalid">
          {errors.age?.message}
        </Form.Control.Feedback>
      </Form.Group>

      <Button type="submit">Create User</Button>
    </Form>
  );
}

function UserList() {
  const [users, setUsers] = useState<User[]>([]);

  const refresh = () => {
    getUsers()
      .then(res => setUsers(res))
      .catch(err => {
        const res = err.response?.data as ErrorResponse;
        alert(res?.message ?? err.message ?? "Unknown error")
      })
  }

  return (
    <div>
      <ListGroup as="ul" className='mb-2'>
        {users.map((user, i) => (
          <ListGroup.Item
            as="li"
            key={i}
          >
            <div className="fw-bold">{user.name}</div>
            <div>id: {user.id}</div>
            <div>age: {user.age}</div>
          </ListGroup.Item>
        ))}
      </ListGroup>
      <Button variant='secondary' onClick={refresh}>Refresh</Button>
    </div>
  )
}

export default function App() {
  return (
    <Container as="main" style={{ maxWidth: "500px" }}>
      <Stack >
        <h1 className="mt-4">Register</h1>
        <UserForm />
        <h2 className="mt-4">User list</h2>
        <UserList />
      </Stack>
    </Container>
  )
}