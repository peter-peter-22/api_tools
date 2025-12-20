import Axios, { type AxiosRequestConfig } from 'axios';
export const AXIOS_INSTANCE = Axios.create({ baseURL: 'http://localhost:8080' });

export const axiosClient = <T>(
  config: AxiosRequestConfig,
  options?: AxiosRequestConfig,
): Promise<T> => {
  const promise = AXIOS_INSTANCE({
    ...config,
    ...options,
  }).then(({ data }) => data);

  return promise;
};