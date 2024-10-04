def juntar(l1, l2):
	if (len(l1) != len(l2)):
		return None
	elif (l1 	== []):
		return []
	
	return [(l1[0], l2[0])] + juntar(l1[1:], l2[1:])


list = [1, 2, 3, 4, 5]
l2 = ["a", "b", "c", "d", "e"]

print(juntar(list, l2))