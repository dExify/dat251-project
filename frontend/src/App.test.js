import { render, screen } from '@testing-library/react';
import App from './App';

test('renders greengafl landing page actions', () => {
  render(<App />);

  expect(
    screen.getByRole('heading', { name: /find a dinner you actually want to cook tonight/i })
  ).toBeInTheDocument();
  expect(screen.getAllByRole('button', { name: /register/i }).length).toBeGreaterThan(0);
  expect(screen.getAllByRole('button', { name: /log in/i }).length).toBeGreaterThan(0);
  expect(screen.getByText(/personalize suggestions/i)).toBeInTheDocument();
  expect(screen.getByText(/get suggestions/i)).toBeInTheDocument();
});
