import { defineConfig } from 'orval';

export default defineConfig({
    'axios': {
        input: { target: './src/api/generated/api.json' },
        output: {
            client: "axios-functions",
            mode: "tags",
            target: './src/api/generated/client',
            override: {
                mutator: {
                    path: './src/api/axiosClient.ts',
                    name: 'axiosClient',
                }
            }
        }
    },
    'zod': {
        input: { target: './src/api/generated/api.json' },
        output: {
            client: "zod",
            mode: "tags",
            target: './src/api/generated/validation',
        },
    },
});