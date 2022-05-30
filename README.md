# Project
Simple project for storing and getting blog posts

## Usage after run
- create post
curl -d "title=Title&content=Content" -X POST http://localhost:8080/posts/create

- get a page of posts
curl -X GET http://localhost:8080/posts?limit=10&offset=0&page=0

- find post by id
curl -X GET http://localhost:8080/posts/c8f96477-3a1b-49ca-86c7-b9ae23a2408e

- delete post by id
curl -X DELETE http://localhost:8080/posts/c8f96477-3a1b-49ca-86c7-b9ae23a2408e