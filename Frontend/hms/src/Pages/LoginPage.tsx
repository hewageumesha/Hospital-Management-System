import React from 'react'
import { TextInput,PasswordInput, Button } from '@mantine/core';
import { IconHeartbeat } from '@tabler/icons-react';
import { useForm } from '@mantine/form';
import { Link } from 'react-router';

const LoginPage = () => {
  type FormValues = {
    email: string;
    password: string;
  };

  const form = useForm<FormValues>({
    initialValues: {
      email: '',
      password: '',
    },
    validate: {
      email: (value: string) =>
        /^\S+@\S+$/.test(value) ? null : 'Invalid email',
      password: (value: string) =>
        /^(?=.*[a-z][A-Z])(?=.*\d)(?=.*[\W_]).{6,}$/.test(value)
          ? null
          : 'Password must be at least 6 characters and include lowercase, uppercase, number, and special character',
      }
  });

  const handleSubmit = (values: { email: string; password: string }) => {
    console.log("Form values:", values);
  };

  return (
    <div style={{background: 'url("/bg.avif")'}} className='w-screen h-screen !bg-cover !bg-center !bg-no-repeat flex flex-col items-center justify-center'>
      <div className='py-3 text-pink-500 flex gap-1 items-center'>
        <IconHeartbeat size={45} stroke={2.5} />
        <span className='font-heading text-4xl font-semibold'>Pulse</span>
      </div>
      <div className='w-[450px] backdrop-blur-md p-10 py-8 rounded-lg'>
        <form onSubmit={form.onSubmit(handleSubmit)} className='flex flex-col gap-5 [&_input]:placeholder-neutral-100 [&_input]:pl-2 [&_input]:text-white [&_.mantine-Input-input]:!border focus-within:[&_.mantine-Input-input]:!border-pink-400 [&_.mantine-Input-input]:!border-white [&_svg]:text-white'>
          <div className='self-center font-medium font-heading text-xl text-white'>Login</div>
          <TextInput className='transition duration-300'
            variant="unstyled"
            size="md"
            radius="md"
            placeholder="Email"
            {...form.getInputProps('email')}
          />
          <PasswordInput className='transition duration-300'
            variant="unstyled"
            size="md"
            radius="md"
            placeholder="Password"
            {...form.getInputProps('password')}
          />
          <Button radius="md" size='md' type='submit' color='pink'>Login</Button>
          <div className='text-neutral-100 text-sm self-center'>Don't have an account? <Link to='/register' className='hover:underline'>Register</Link></div>
        </form>
      </div>
    </div>
  )
}

export default LoginPage;
