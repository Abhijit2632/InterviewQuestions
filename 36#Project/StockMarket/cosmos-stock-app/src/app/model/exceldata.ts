import { Notes } from "./notes";

export interface Exceldata {

    companyName: string,
        companyLTP: number,
        companyOpen: number,
        companyHigh: number,
        companyLow: number,
        companyVolume: number,
        companyPreviousClose: number,
        companyNotes:Notes
}
