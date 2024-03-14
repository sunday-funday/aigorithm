#!/usr/bin/env python3

def solution(topping):
	
	answer = 0
	left = set()
	right = dict()
	
	for i in topping:
		if i in right:
			right[i] += 1
		else:
			right[i] = 1
			
	for i in topping:
		right[i] -= 1
		left.add(i)
		
		if right[i] == 0:
			right.pop(i)
			
		if len(left) == len(right):
			answer += 1
		elif len(left) > len(right):
			break

	return answer
