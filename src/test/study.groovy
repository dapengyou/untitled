package test

def x = fab(5)
println x

int fab(int number) {
    int result = 1
    result.upto(number, { num -> result *= num })
    return result
}
