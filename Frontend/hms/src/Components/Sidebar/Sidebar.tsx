import { Avatar, Text } from '@mantine/core';
import {
  IconHeartbeat,
  IconLayoutDashboard,
  IconStethoscope,
  IconMoodHeart,
  IconCalendarCheck,
  IconVaccine,
} from '@tabler/icons-react';
import React from 'react';
import { NavLink } from 'react-router-dom';

const links = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    icon: <IconLayoutDashboard stroke={1.5} />,
  },
  {
    name: 'Doctors',
    url: '/doctors',
    icon: <IconStethoscope stroke={1.5} />,
  },
  {
    name: 'Patients',
    url: '/patients',
    icon: <IconMoodHeart stroke={1.5} />,
  },
  {
    name: 'Appointments',
    url: '/appointments',
    icon: <IconCalendarCheck stroke={1.5} />,
  },
  {
    name: 'Pharmacy',
    url: '/pharmacy',
    icon: <IconVaccine stroke={1.5} />,
  },
];

const Sidebar = () => {
  return (
    <div className='w-64 h-screen fixed overflow-y-auto hide-scrollbar bg-dark flex flex-col gap-7 items-center'>
      <div className='fixed z-[500] bg-dark py-3 text-primary-400 flex gap-1 items-center'>
        <IconHeartbeat size={40} stroke={2.5} />
        <span className='font-heading text-3xl font-semibold'>Pulse</span>
      </div>
      <div className='flex flex-col gap-5 mt-20'>
        <div className='flex flex-col gap-1 items-center'>
          <div className='p-1 bg-white rounded-full shadow-lg'>
            <Avatar src='avatar.jpeg' alt="it's me" size='xl' variant='filled' />
          </div>
          <span className='font-medium text-light'>Umesha</span>
          <Text c='dimmed' size='xs' className='text-light'>
            Admin
          </Text>
        </div>
        <div className='flex flex-col gap-1'>
          {links.map((link) => (
            <NavLink
              to={link.url}
              key={link.url}
              className={({ isActive }) =>
                `flex items-center gap-3 w-full font-medium text-neutral-900 px-4 py-5 rounded-lg text-light ${
                  isActive ? 'bg-primary-400' : 'hover:bg-gray-100 hover:text-dark'}`
              }
            >
              {link.icon}
              <span>{link.name}</span>
            </NavLink>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Sidebar;
