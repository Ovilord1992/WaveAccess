## Register User
```POST localhost:8080/api/auth/signup```
```json
  {
    "username":"user1",
    "password":"12345678",
    "email":"ovilorrrd4199212@gmail.com"
  }  
```
---
## Get Jwt Token
```POST localhost:8080/api/auth/signin```
```json
  {
    "username":"user1",
    "password":"12345678"
  }  
```
---
## Get all Users for Role Admin
```GET localhost:8080/api/admin/getAllUsers```
___
## Get one User
```GET localhost:8080/api/admin/getOneUser?username=user```
___

## Add role for User
```GET localhost:8080/api/admin/userRoleAdd?idUser=1&role=listener```
___

## Remove role for User
```GET localhost:8080/api/admin/userRoleRemove?idUser=1&role=listener```
___

## Create new Talk
```POSR localhost:8080/api/talk/create```
```json
  {
    "name":"Saving cats in Congo, Africa",
    "about":"Cats lost of drink alcohol"
  }
```
___

## Add Talk in Schedule
```POST localhost:8080/api/schedule/add```
```json
  {
    "room_id": 1,
    "talk_id": 1,
    "startTime": "2022-09-10T20:09.82261+03",
    "endTime": "2022-09-10T21:50.82261+03"
  }
```
___

## Get all Schedules
```GET localhost:8080/api/schedule/getAllSchedules```
___
