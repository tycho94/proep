import { Component } from '@angular/core';
import { AccountService } from "./account.service";


@Component({
    selector: 'account-create',
    providers: [AccountService],
    template: `
        <router-outlet></router-outlet>
    `
})

export class AccountCreateComponent {
    service: AccountService;
    response: string;
    userData: {};

    constructor (service: AccountService) {
        this.service = service;
    }

    onPost() {
        this.service
        .postData(this.userData);
    };
}
