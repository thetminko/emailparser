import express from 'express';
import { parse } from './EmailParser';

// Create a new express application instance
const app: express.Application = express();

app.get('/', async (req, res) => {
  res.json({ msg: 'Hello World!' });
});

app.listen(3000, () => {
  parse();
  console.log('Example app listening on port 3000!');
});
