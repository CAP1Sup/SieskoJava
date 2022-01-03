def processLine():
    distances = [450, 140, 120, 320, 250, 80]
    input_string = input("Enter the input: ")
    input_arr = input_string.split(", ")
    if  input_arr[0] == "A":
        start = 0
    if input_arr[0] == "B":
        start = 1
    if input_arr[0] == "C":
        start = 2
    if input_arr[0] == "D":
        start = 3
    if input_arr[0] == "E":
        start = 4
    if input_arr[0] == "F":
        start = 5
    if input_arr[0] == "G":
        start = 6

    if  input_arr[1] == "A":
        end = 0
    if input_arr[1] == "B":
        end = 1
    if input_arr[1] == "C":
        end = 2
    if input_arr[1] == "D":
        end = 3
    if input_arr[1] == "E":
        end = 4
    if input_arr[1] == "F":
        end = 5
    if input_arr[1] == "G":
        end = 6

    distance = 0
    for i in range(start, end):
        distance += distances[i]

    if input_arr[2] == "C":
        mpg = 28
    if input_arr[2] == "M":
        mpg = 25
    if input_arr[2] == "F":
        mpg = 22
    if input_arr[2] == "V":
        mpg = 20

    if input_arr[3] == "I":
        mph = 65
    if input_arr[3] == "H":
        mph = 60
    if input_arr[3] == "M":
        mph = 55
    if input_arr[3] == "S":
        mph = 45
    hours = int(distance / mph)
    min = round((distance / mph - hours) * 60)

    if hours < 10:
        if min < 10:
            time_output = f"0{hours}:0{min}"
        else:
            time_output = f"0{hours}:{min}"
    else:
        if min < 10:
            time_output = f"{hours}:0{min}"
        else:
            time_output = f"{hours}:{min}"

    cost = round((distance / mpg) * float(input_arr[4]), 2)

    cost_arr = str(cost).split(".")
    if (len(cost_arr[1]) == 1):
        print(f"{distance}, {time_output}, ${cost}0")
    else:
        print(f"{distance}, {time_output}, ${cost}")

processLine()
processLine()
processLine()
processLine()
processLine()