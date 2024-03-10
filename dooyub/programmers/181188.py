#!/usr/bin/env python3

def solution(targets):
	
	array = sorted(targets, key=lambda x: x[1])
	last = 0
	answer = 0
	
	for i in array:
		if i[0] >= last:
			last = i[1]
			answer += 1
			
	return answer