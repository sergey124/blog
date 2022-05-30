# Project
Simple project for storing and getting blog posts

## Usage after run
- get all posts
curl -X GET http://localhost:8080/posts

- find post by title
curl -X GET http://localhost:8080/posts/First%20post

- create post
curl -d "title=Title&content=Content" -X POST http://localhost:8080/posts/create
