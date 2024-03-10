#!/usr/bin/env python3

import heapq

def solution(book_time):
	array = sorted(book_time, key=lambda x: (x[0][:2], x[0][2:]))
	newArray = []
	queue = []
	
	for i in array:
		enter = list(map(int, i[0].split(":")))
		out = list(map(int, i[1].split(":")))
		
		newArray.append([int(enter[0]) * 60 + int(enter[1]), int(out[0]) * 60 + int(out[1])])
		
	
	for i in newArray:
		if len(queue) == 0:
			heapq.heappush(queue, i[1])
		else:
			minTime = heapq.nsmallest(1, queue)
			if i[0] >= minTime[0] + 10:
				heapq.heappop(queue)
			heapq.heappush(queue, i[1])
	
	return len(queue)