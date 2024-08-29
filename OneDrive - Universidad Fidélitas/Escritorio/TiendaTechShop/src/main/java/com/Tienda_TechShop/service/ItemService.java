package com.Tienda_TechShop.service;

import com.Tienda_TechShop.domain.Item;
import java.util.ArrayList;
import java.util.List;

public interface ItemService {

    List<Item> listaItems = new ArrayList<>();

    public List<Item> get();

    //Se recupera el registro que tiene el idItem pasado por parámetro
    //Si no existe en la tabla se retorna null
    public Item get(Item item);

    //Se elimina el registro que tiene el idItem pasado por parámetro
    public void delete(Item item);

    //Si el objeto item tiene un idItem que existe en la tabla item
    //El registro se actualiza con la nueva información
    //Si el item NO existe en la tabla, se crea el registro con esa información
    public void save(Item item);

    public void actualiza(Item item);

    public void facturar();
}
