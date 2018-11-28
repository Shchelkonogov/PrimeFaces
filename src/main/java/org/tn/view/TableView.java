package org.tn.view;

import org.tn.beans.BeanTable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Контроллер для обработки jsf
 */
@Named(value = "tableView")
@ViewScoped
public class TableView implements Serializable {

    private int value;
    private List<String> list;

    @EJB
    private BeanTable bean;

    public TableView() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void search() {
        list = bean.loadData(value);
    }
}
