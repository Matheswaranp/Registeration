# Registeration
 
How to refresh my grid in atomatically


This is my code...

package com.Reg.Reg;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

/**
 * Created by kenhike on 29/5/17.
 */
@SpringUI
public class RegUI extends UI
{
    @Autowired
    private RegRopos reg;
    @Override
    protected void init(VaadinRequest request)
    {
        HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();

        VerticalLayout vertical=new VerticalLayout();
        TextField name=new TextField("Name");
        vertical.addComponent(name);
        PasswordField password=new PasswordField("Password");
        vertical.addComponent(password);
        TextField email=new TextField("Email");
        vertical.addComponent(email);
        TextField address=new TextField("Address");
        vertical.addComponent(address);
        Button button=new Button("Submit");
        vertical.addComponent(button);
        setContent(vertical);
        vertical.setMargin(true);
        vertical.setSpacing(true);
        vertical.setMargin(true);

        //Create Grid.....
        HorizontalLayout layout=new HorizontalLayout();
        Grid grid=new Grid();
        layout.addComponent(grid);
        grid.addColumn("name",String.class);
        grid.addColumn("password",String.class);
        grid.addColumn("email",String.class);
        grid.addColumn("address",String.class);

        grid.getColumn(grid);

        setContent(layout);
        // Add Rows
       // grid.addRow("mathes","123","pp@gmai.com","chennai");


        grid.setColumnOrder("name", "password","email", "address");

        horizontalSplitPanel.setSplitPosition(50,Unit.PERCENTAGE);
        horizontalSplitPanel.setFirstComponent(vertical);
        horizontalSplitPanel.setSecondComponent(grid);
        setContent(horizontalSplitPanel);

        button.addClickListener( list ->{

            reg.save(new RegPojo(name.getValue(),password.getValue(),email.getValue(),address.getValue()));
            grid.refreshRows(name,password,email,address);
        });
        for(RegPojo p:reg.findAll()) {
            System.out.println(p.toString());

            grid.addRow(p.getName(),p.getPassword(),p.getEmail(),p.getAddress());



        }

    }



}
