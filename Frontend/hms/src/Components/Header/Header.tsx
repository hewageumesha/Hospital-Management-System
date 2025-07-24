import { ActionIcon, Button } from '@mantine/core'
import {IconBellRinging, IconLayoutSidebarLeftCollapseFilled} from '@tabler/icons-react'
import React from 'react'
import ProfileMenu from './ProfileMenu'
import { Link } from 'react-router'

const Header = () => {
  return (
    <div className='flex'>
      <div className='w-72'></div>
      <div className='bg-light shadow-lg h-16 flex justify-between px-5 items-center w-full'>
        <ActionIcon variant="transparent" aria-label="Settings" size="md">
            <IconLayoutSidebarLeftCollapseFilled style={{ width: '90%', height: '90%' }} stroke={1.5} />
        </ActionIcon>
        <div className='flex gap-5 items-center'>
          <Link to="login"><Button>Login</Button></Link>
          <ActionIcon variant="transparent" aria-label="Settings" size="md">
            <IconBellRinging style={{ width: '90%', height: '90%' }} stroke={1.5} />
          </ActionIcon>
          <ProfileMenu/>
        </div>
      </div>
    </div>
  )
}

export default Header