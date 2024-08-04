package com.ecommerce.com.digimart.dbms.versioning;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.extern.log4j.Log4j2;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import com.ecommerce.com.digimart.dbms.utilities.HikariConnectionPool;

@Log4j2
public abstract class AMockData
{
    HikariConnectionPool hcp;

    //    public abstract void processAndIngestMockedData(List<String[]> data) throws Exception;
    public AMockData(String hostAddress, String database, String username, String password)
    {
        this.hcp = new HikariConnectionPool(hostAddress, database, username, password, null);
    }

    protected abstract void insertData(List<String[]> data);

    public void processAndIngestMockedData(List<String[]> data) throws Exception
    {
        if (!data.isEmpty())
        {
                insertData(data);
        }
        else
        {
            throw new Exception("Data is null");
        }
    }

    public List<String[]> readCsv(byte[] input, boolean hasHeaders)
    {
        int startIndex = hasHeaders
                ? 1
                : 0;
        List<String[]> list = new ArrayList<>();

        try
        {
            // Read the text input stream one line at a time and display each line.
            CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(new ByteArrayInputStream(input)))
                    .withSkipLines(startIndex)
                    .build();

            list = csvReader.readAll();
            csvReader.close();
        }
        catch (IOException e)
        {
            return null;
        }
        catch (CsvException e)
        {
            throw new RuntimeException(e);
        }

        return list;
    }
}
