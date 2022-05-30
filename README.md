# Project
Simple project for storing and getting blog posts

## Usage after run
- get a page of posts
curl -X GET http://localhost:8080/posts?limit=10&offset=0&page=0

- find post by title
curl -X GET http://localhost:8080/posts/First%20post

- create post
curl -d "title=Title&content=Content" -X POST http://localhost:8080/posts/create
