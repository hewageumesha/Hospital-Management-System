import React from 'react'
import { TextInput,PasswordInput, Button, SegmentedControl } from '@mantine/core';
import { IconHeartbeat } from '@tabler/icons-react';
import { useForm } from '@mantine/form';
import { Link } from 'react-router';

const RegisterPage = () => {
  type FormValues = {
    type: string,
    email: string;
    password: string;
    confirmPassword: string;
  };
  const form = useForm<FormValues>({
    initialValues: {
      type: 'PATIENT',
      email: '',
      password: '',
      confirmPassword: '',
    },
    validate: {
      email: (value: string) =>
        /^\S+@\S+$/.test(value) ? null : 'Invalid email',
      password: (value: string) =>
        /^(?=.*[a-z][A-Z])(?=.*\d)(?=.*[\W_]).{6,}$/.test(value)
          ? null
          : 'Password must be at least 6 characters and include lowercase, uppercase, number, and special character',
      confirmPassword: (value: string, values) =>
      value === values.password
        ? null
        : 'Passwords do not match',
    },
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
          <div className='self-center font-medium font-heading text-xl text-white'>Register</div>

          <SegmentedControl {...form.getInputProps('type')} fullWidth size="md" radius="md" color='pink' bg='none' data={[{label: 'Patient', value: 'PATIENT'}, {label: 'Doctor', value: 'DOCTOR'}, {label: 'Admin', value: 'ADMIN'}]} className='[&_*]:!text-white border border:white' />

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

          <PasswordInput className='transition duration-300'
            variant="unstyled"
            size="md"
            radius="md"
            placeholder="Confirm Password"
            {...form.getInputProps('confirmPassword')}
          />

          <Button radius="md" size='md' type='submit' color='pink'>Register</Button>

          <div className='text-neutral-100 text-sm self-center'>Have an account? <Link to='/login' className='hover:underline'>Login</Link></div>
        </form>
      </div>
    </div>
  )
}

export default RegisterPage;
