# Tenta 2018 April


## Uppgift 1
```
int[][] b = { {1, 0, 0, 4},
{0, 2, 3, 0},
{0, 2, 3, 0},
{1, 0, 0, 4} };
int[] u = new int[b.length];
for (int i = 0; i < u.length; i++)
for (int j = 0; j < b[i].length; j++)
u[i] = u[i] + b[i][j];
int[][] v = new int[2][b.length];
for (int i = 0; i < b.length; i++)
{
v[0][i] = b[i][i];
v[1][i] = b[i][b[i].length - 1 - i];
}
```
## a.) Rita den vektor som refereras med referensen u.

## Min lösning:

**u --> | 5 | 5 | 5 | 5 |**

## b.) Rita den vektor som refereras med referensen v.

## min lösning:

          +-----+
          |     |   v[0] -------> | 1 | 2 | 3 | 4 |
   v -->  +-----+  
          |     |   v[1] -------> | 4 | 3 | 2 | 1 |
          +-----+
