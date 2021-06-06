package com.list.oseias.br.listviewtutorial;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Escola on 24/06/2016.
 */
public class TaskDao {

    {
        Task t1 = new Task();
        t1.setDescricao("trabalho de TM");
        t1.setDtaFinal(new Date(2016,06,20));

        Task t2 = new Task();
        t2.setDescricao("trabalho de DSII");
        t2.setDtaFinal(new Date(2016,06,22));

        Task t3 = new Task();
        t3.setDescricao("trabalho de PCII");
        t3.setDtaFinal(new Date(2016, 06, 25));

        this.tasks.add(t1);
        this.tasks.add(t2);
        this.tasks.add(t3);
    }

    private Collection<Task> tasks = new HashSet<>();

    public Collection listarTudo(){
        return this.tasks;
    }
}
