package com.example.RomanNumeralGenerator;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private Button button_int;
    private Button button_roman;
    private TextField textField_int;
    private TextField textField_roman;
    private TextField display;

    public MainView() {
        setId("mainview");
        setSpacing(true);
        setHeight("300px");
        init(); // Initialize the web interface
        listen_buttons();
    }

    private void init() {
        add(new H1("RomanNumeralGenerator")); // Create web interface header

        button_int = new Button("Convert int to roman"); // Create button for integer to roman conversion
        textField_int = new TextField(); // Create textfield for integer

        add(new HorizontalLayout(textField_int, button_int));

        button_roman = new Button("Convert roman to int"); // Create button for roman to integer conversion
        textField_roman = new TextField(); // Create textfield for roman string number

        add(new HorizontalLayout(textField_roman, button_roman));

    }

    private void listen_buttons() {
        RomanNumeralGenerator convert; // Setting up converter
        convert = new Converter();

        display = new TextField(); // Create textfield for the conversion result

        // When user press button_int  we read the integer from textfield_int
        button_int.addClickListener(e -> {
            int integer = Integer.parseInt(textField_int.getValue());
            textField_int.clear();
            // After reading integer we pass it to generate which returns roman string number
            String result = convert.generate(integer);
            // If generate returns null, integer is out of bounds
            if (result == null) {
                // Error message function
                createReportError();
            }else {
                // Adding returned value to display textfield
                display.setReadOnly(true);
                display.setId("display");
                display.setValue(integer + " = " + convert.generate(integer));
                add(display);
            }
        });

        // When user press button_roman we read the roman string number from textfield_roman
        button_roman.addClickListener(e -> {
            String roman_str = textField_roman.getValue();
            textField_roman.clear();
            // After reading roman string number we pass it to parse which returns integer
            display.setReadOnly(true);
            display.setId("display");
            display.setValue(roman_str + " = " + convert.parse(roman_str)); // Adding returned value to display textfield
        });
    }

    // Function for error message display
    public void createReportError() {

        Notification notification = new Notification(); // Create notification
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

        Div text = new Div(new Text("Failed to convert"));

        // Add button to close notification window
        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.getElement().setAttribute("aria-label", "Close");
        closeButton.addClickListener(event -> notification.close());

        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
        layout.setAlignItems(Alignment.CENTER);

        notification.add(layout);
        notification.open();
    }

}
