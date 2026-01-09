import axiosInstance from "../Interceptor/AxiosInterceptor";

const registerUser = async (user) => {
    return axiosInstance.post('/user/register', user)
        .then((response) => response.data)
        .catch((error) => { throw error; });
}

const loginUser = async (user) => {
    return axiosInstance.post('/user/login', user)
        .then((response) => response.data)
        .catch((error) => { throw error; });
}

export { registerUser, loginUser };
