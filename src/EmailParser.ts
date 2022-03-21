/* eslint-disable no-sync */
import fs from 'fs';
import path from 'path';
import { simpleParser } from 'mailparser';

export const parse = async () => {
  await parseEmail('email1.eml');
  await parseEmail('email2.eml');
};

const parseEmail = async (filename: string) => {
  const buffer: Buffer = fs.readFileSync(path.join(path.resolve(), filename));
  const parsedEmail = await simpleParser(buffer);
  const { from, to, subject, text, textAsHtml, html, attachments } = parsedEmail;

  console.log(`Running for email ${filename}`);
  console.log({ from, to, subject, text, textAsHtml, html, attachments });
};
