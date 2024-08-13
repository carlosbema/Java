def prefixo(*args):
    print(args), type(args)
    base = args[0]

    for palavra in args:
        new_base = ''
        position = 0
        
        for letra in palavra:
            if letra == base[position]:
                new_base += letra
                position += 1
            else:
                continue
        final = new_base
    return final

print(prefixo('tesoura', 'tesouro', 'tesoubo'))