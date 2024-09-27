# Slide 52/53

def reduzir(lista, f, neutro):
    if lista == []:
        return neutro
    return f(lista[0], reduzir(lista[1:], f, neutro))


# Example: length of [1, 2, 4]
reduzir([1,2,4], lambda h,r0: r0 + 1, 0)

# Example: function to compute the sum of "lista"
def soma(lista): return reduzir(lista, lambda h,r0: h+r0, 0)

# Example: function to check if "x" occurs in "lista"
def ocorre(x, lista):
    return reduzir(lista, lambda h,r0: h == x or r0, False)
    