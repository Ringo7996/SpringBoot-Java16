package vn.techmaster.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import vn.techmaster.demo.other_package2.Dress;

@Component
public class GirlFriend {

    @Autowired
    public Outfit outfit;

    public GirlFriend(){
    }

    public GirlFriend(Outfit outfit) {
        this.outfit = outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    public Outfit getOutfit() {
        return this.outfit;
    }
}
