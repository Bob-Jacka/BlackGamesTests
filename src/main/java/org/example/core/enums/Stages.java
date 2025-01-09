public enum Stages {

    PROD("https://fairspin.io/ru/casino/all/provider/Web3Originals"),
    DEV("https://dev.sprut.cloud/wl/index.php"),
    STABLE("https://stable.sprut.cloud/wl/index.php"),
    PREPROD("https://prod.sprut.cloud/wl/index.php"),
    
    SLOT_PROD("https://web3blockchaingame.com/");

    private String stage_name;

    Stages(String name) {
        this.stage_name = name;
    }

    public String getName() {
        return this.stage_name;
    }
}