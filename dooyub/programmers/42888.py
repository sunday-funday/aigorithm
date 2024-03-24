#!/usr/bin/env python3

def solution(record):
	answer = []
	user = {}
	
	for i in record:
		split = i.split()
		if split[0] == "Enter" or split[0] == "Change":
			user[split[1]] = split[2]
	
	for i in record:
		split = i.split()
		if split[0] == "Enter":
			answer.append(f'{user[split[1]]}님이 들어왔습니다.')
		elif split[0] == "Leave":
			answer.append(f'{user[split[1]]}님이 나갔습니다.')
			
	return answer