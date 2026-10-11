def resumir_importes(importes):
    if len(importes) == 0:
        return None

    total = sum(importes)

    return {
        "total": total,
        "media": total / len(importes),
        "minimo": min(importes),
        "maximo": max(importes)
    }


importes = [10, 20, 30, 40]
resumen = resumir_importes(importes)

if resumen is not None:
    print(resumen)
