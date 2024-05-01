import axios, { AxiosRequestConfig, AxiosResponse } from 'axios';

const axiosClient = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
      'Content-Type': 'application/json',
    },
  });

const get = async <T>(url: string, config?: AxiosRequestConfig): Promise<T> => {
  try {
    const response: AxiosResponse<T> = await axiosClient.get(url, config);
    return response.data;
  } catch (error) {
    console.error('GET Request Error:', error);
    throw error;
  }
};

const post = async <T, R>(url: string, data?: T, config?: AxiosRequestConfig): Promise<R> => {
  try {
    const response: AxiosResponse<R> = await axiosClient.post(url, data, config);
    return response.data;
  } catch (error) {
    console.error('POST Request Error:', error);
    throw error;
  }
};

export const HttpClient = {
  get,
  post,
};