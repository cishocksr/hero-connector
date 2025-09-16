import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'
import path from 'node:path'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: {
      '@': path.resolve(__dirname, 'src'),
    },
  },
  server: {
    host: true,   // allows access from LAN / other devices
    port: 5173,   // default Vite port; change if you like
    open: false,  // set true if you want the browser to auto-open
  },
})
