package uni.pu.fmi.commands;


import uni.pu.fmi.helpers.ClientInputHelper;

public class Cashier implements ICommand {
    private final Chief chief;

    public Cashier(Chief chief) {
        this.chief = chief;
    }

    @Override
    public void ExecuteTask() {
        ClientInputHelper.DisplayMenu();
        chief.setOrder(ClientInputHelper.TakeOrder());
    }
}
