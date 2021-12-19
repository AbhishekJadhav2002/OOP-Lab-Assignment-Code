package Packages.FileHandler;

abstract interface PrinterMethods
{
    abstract void MakeFile(String NewFileName);
    abstract void AppendToFile(String FileName, String CustomerDetails);
}