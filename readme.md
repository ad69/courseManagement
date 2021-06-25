
Project: Course Management System(Objective is to provide facility to add courses and trainers for a particular year. Also we need to see the summarized view of both)
1. In the Course Management screen, must land the user in the search screen.
2. User must be able to create, view, Edit and delete the Course.
3. User must be able to view the trends across many data sets such as - locations, courses, etc.
4. The model must have the fields such as - Course Description, skills , Pre requesite, Trainer details, Last Updated, Description, Feedback etc.
5. Ability to email the participants about the training.

[✓] Add Cousre=> post
[✓] map dto to object
[✓] Get all course
[✓] get courseById
[✓] delete courseByid
[✓] update course => change updatedAt date => put or patch
[✓] send proper response and message => responseEntity
[✓] find courseByLocation
[✓] find all courseByTrainer => just input trainer name
[✓] find all courseBySkill => input skill  eg: java 
[✓] find latest courses => sort by date
[] handle exceptions
[✓] email facility => **important| either use gmail or mailchimp
[] email to one person
[] email to many people
[] taking too much time => add  async => much faster
[✓] add swagger and swagger ui
[✓] cors error if sent request from react=> solved:1. add @crossorigin to controller 2. config/webconfig
[] student microservice = make another project for students and use rest template for communication b/w them
-------
[✓] course material functionality
[✓] upload single course material for courses => multipart file
[✓] make functionality to download files
[✓] get courseMaterial by id
[] find how to send request for multipart data in one request
[✓] upload multiple course material for courses
[] create user type: ADMIN,STUDENT :try to use inheritance or just enum
[] upload avatar for user
[] login 
[] protect admin routes