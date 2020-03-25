package core.enums;

import core.DTO;

/**
 * These enumeration is used to give the driver a specific size;
 * The width and height are set here so the user can get the values directly from here through getters;
 */
public enum SizeEnum {

    MAX(50, 50),
    PHONE(411, 823),
    TABLET(768, 1024);

    private int width;
    private int height;

    SizeEnum(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static SizeEnum returnSize(){
        if (DTO.getSize().equalsIgnoreCase("max")) {
            return MAX;
        } else if (DTO.getSize().equalsIgnoreCase("phone")) {
            return PHONE;
        } else return TABLET;
    }

    public int getWidth() {
        return width;
    }

    public int getHight() {
        return height;
    }
}

