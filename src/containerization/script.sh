#!/bin/bash

if command -v apt > /dev/null; then
  echo "apt is used here"
elif command -v yum > /dev/null; then
  echo "yum is used here"
else
  echo "I have no Idea what im doing here"
fi