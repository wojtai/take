# get all
curl localhost:5000/api/students/

# add 2 students
curl -X POST -H "Content-Type: application/json" -d '{"index":213457,"firstName":"Jan","lastName":"Kowalski"}' localhost:5000/api/students/
curl -X POST -H "Content-Type: application/json" -d '{"index":213458,"firstName":"Zenon","lastName":"Zawada"}' localhost:5000/api/students/

# get all
curl localhost:5000/api/students

# get student id = 1
curl localhost:5000/api/students/1

# alter student id = 2
curl -X POST -H "Content-Type: application/json" -d '{"index":213458,"firstName":"Waldemar","lastName":"Zawada"}' localhost:5000/api/students/2

# delete student id = 3
curl -X DELETE localhost:5000/api/students/3

# get all
curl localhost:5000/api/students