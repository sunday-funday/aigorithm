#!/usr/bin/env python3

def solution(p):
	
	def balance(a):
		if a.count("(") == a.count(")"):
			return True
		else:
			return False
		
	def proper(a):
		stack = []
		for i in a:
			if i == "(":
				stack.append(i)
			else:
				if len(stack) > 0:
					stack.pop()
				else:
					return False
		if len(stack) == 0:
			return True
		else: 
			return False
		
	def recurse(a):
		u = ""
		stack = []
		
		if len(a) == 0:
			return a

		for i in a:
			if len(stack) == 0:
				if len(u) > 0:
					break
				else:
					stack.append(i)
			else:
				if i == "(":
					if stack[-1] == ")":
						stack.pop()
					else:
						stack.append(i)
				else:
					if stack[-1] == "(":
						stack.pop()
					else:
						stack.append(i)
			u += i
		
		if proper(u):
			return u + recurse(a[len(u):])
		else:
			new = u[1:-1].replace("(", ".").replace(")", "(").replace(".", ")")
			return "(" + recurse(a[len(u):]) + ")" + new
	
	if proper(p):
		return p
	else:
		return recurse(p)