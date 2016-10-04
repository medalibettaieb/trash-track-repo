package tn.esprit.tt.services.training;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class NormalCaddyServices
 */
@Stateless

public class NormalCaddyServices implements NormalCaddyServicesRemote, NormalCaddyServicesLocal {
	private int num;

 public NormalCaddyServices() {
	// TODO Auto-generated constructor stub
}

    public int getNum() {
        return num;
    }

    public void setNum() {
        this.num++;
    }
}