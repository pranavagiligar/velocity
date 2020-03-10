Setting system environment variable varies from OSs

---

**Linux**
1. open `/etc/profile` with super user access and add `MONGO_URL_CON="mongodb://{username}:{password}@{server-ip-address-or-dns-address}:{portnumber}/{database-name}"` in the end 
2. save it and logout-login or restart the OS

**macOS Catalina 10.15.3**
1. open `/etc/zprofile` with super user access and add `MONGO_URL_CON="mongodb://{username}:{password}@{server-ip-address-or-dns-address}:{portnumber}/{database-name}"` in the end 
2. save it and logout-login or restart the OS

**Windows**
1. Choose `Advanced System settings`
2. Click on the `Environment Variables` button
3. Click on the `New` button under `System Variables`
4. Set `MONGO_URL_CON` as the environment variable name
5. Set the `mongodb://{username}:{password}@{server-ip-address-or-dns-address}:{portnumber}/{database-name}` as the environment variable Value
6. Click `OK` and close the `MONGO_URL_CON` environment variable editor

---

Example MongoDB connection string looks like `mongodb://pranava:vel0city@localhost:27017/eventms`

##### The setup of cloud MongoDB hosted server is [HERE](CLOUD_MONGODB_SETUP.md)

---

Project Velocity -
[Copyright (c) 2020 Pranava Giligar](https://github.com/pranavagiligar/velocity/blob/master/LICENSE)