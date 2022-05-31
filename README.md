# Project
Simple project for storing and getting blog posts

## Usage after run
### Posts
- create post
curl -d "title=Title&content=Content" -X POST http://localhost:8080/posts/create

- get a page of posts
curl -X GET http://localhost:8080/posts?limit=10&offset=0&page=0

- find post by id
curl -X GET http://localhost:8080/posts/c8f96477-3a1b-49ca-86c7-b9ae23a2408e

- delete post by id
curl -X DELETE http://localhost:8080/posts/c8f96477-3a1b-49ca-86c7-b9ae23a2408e

### Comments
- get all comments for post
curl -X GET http://localhost:8080/posts/e8546746-6b83-42cf-9386-0ce602f16d7a/comments?limit=10&offset=0&page=0

- get a comment by id
curl -X GET http://localhost:8080/posts/e8546746-6b83-42cf-9386-0ce602f16d7a/comments/317c5220-e0bb-11ec-9be1-e16aa7dfa956

- create comment
curl -d "content=Another comment" -X POST http://localhost:8080/posts/e8546746-6b83-42cf-9386-0ce602f16d7a/comments

- delete comment
curl -X DELETE http://localhost:8080/posts/e8546746-6b83-42cf-9386-0ce602f16d7a/comments/317c5220-e0bb-11ec-9be1-e16aa7dfa956