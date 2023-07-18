package lecture11;

public class Table<T>{
    private T[][] table;

    Table(Integer size){
        this(size, size);
    }

    @SuppressWarnings("unchecked")
    Table(Integer x, Integer y){
        table = (T[][]) new Object[y][x];
    }

    Integer getMaxX(){
        return table[0].length;
    }

    Integer getMaxY(){
        return table.length;
    }

    T get(Integer x, Integer y){
        if(x > table[0].length || y > table.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        return table[y][x];
    }

    void set(T value, Integer x, Integer y){
        if(x > table[0].length || y > table.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        table[y][x] = value;
    }

    void print(){
        for(Integer j = 0; j < getMaxY(); j++){
            for(Integer i = 0; i < getMaxX(); i++){
                System.out.printf("%2s ", get(i, j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Table<Integer> table = new Table<Integer>(5, 4);
        for(Integer i = 0; i < table.getMaxX(); i++){
            for(Integer j = 0; j < table.getMaxY(); j++){
                table.set(Integer.valueOf(i + j), i, j);
            }
        }
        table.print();
    }
}
