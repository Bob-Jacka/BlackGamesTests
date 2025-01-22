package org.example.core.enums;

public enum Stages_web_addresses {

    PROD("https://fairspin.io/ru/casino/all/provider/Web3Originals"),

    DEV("https://dev.sprut.cloud/wl/index.php"),
    STABLE("https://stable.sprut.cloud/wl/index.php"),
    PREPROD("https://prod.sprut.cloud/wl/index.php"),

    SLOT_PROD("https://web3blockchaingame.com/");

    private final String stage_name;

    Stages_web_addresses(String name) {
        this.stage_name = name;
    }

    /**
     * @param stage_name string that represents stage name
     * @return Stage new object
     */
    public static Stages_web_addresses reverse_getting(String stage_name) {
        Stages_web_addresses stages;
        switch (stage_name) {
            case "prod": {
                stages = PROD;
                break;
            }
            case "dev": {
                stages = DEV;
                break;
            }
            case "stable": {
                stages = STABLE;
                break;
            }
            case "preprod": {
                stages = PREPROD;
                break;
            }
            case "slot_prod": {
                stages = SLOT_PROD;
                break;
            }
            default:
                System.out.println("Entering default branch of reverse_getting method");
                return STABLE;
        }
        return stages;
    }

    public String getStage_name() {
        return this.stage_name;
    }
}