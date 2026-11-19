## Interfaz vs. Clase Abstracta
Interfaz (implements): Exacto. Es un contrato de métodos sin cuerpo que obliga a quien la implementa a definirlos. Una clase puede implementar varias interfaces a la vez. (Nota: desde Java 8 las interfaces también pueden tener métodos default con cuerpo, pero su función principal sigue siendo el contrato).
Clase Abstracta (extends): Acertaste en que puede tener atributos, constructores y métodos ya hechos, y en que una hija solo puede heredar de una.

El ajuste: Sí puede obligar. Si dentro de la clase abstracta escribes un método con la palabra abstract (sin cuerpo), las clases hijas están obligadas a implementarlo. Lo que es opcional son los métodos que ya vienen escritos con cuerpo. Además, nunca puedes hacer new directamente de una clase abstracta.

Característica,Interfaz (implements),|||Clase Abstracta (extends)
¿Se puede hacer new?,No,No
¿Cuántas puede usar una hija?,"Varias (implements A, B)",||||||Solo una (extends Padre)
¿Puede tener atributos con estado?,No (solo constantes),||||||Sí (como una clase normal)
¿Obliga a implementar métodos?,Sí (todos los métodos sin cuerpo),||||||Solo los marcados como abstract
¿Para qué se usa?,"Definir un contrato (""qué sabe hacer"")",||||||"Compartir código base y datos (""qué es"")"

## Sobrecarga (Overloading)
Es tener el mismo nombre de método dentro de la misma clase, pero cambiando los parámetros (cantidad o tipo). Por ejemplo: buscar(Long id) y buscar(String verbo). (No confundir con sobrescritura / @Override, que es cuando una hija reescribe un método que heredó del padre manteniendo exactamente la misma firma).