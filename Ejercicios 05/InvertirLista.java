import java.util.List;
import java.util.ArrayList;

public class InvertirLista {
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> invertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            invertida.add(lista.get(i));
        }
        return invertida;
    }
}
