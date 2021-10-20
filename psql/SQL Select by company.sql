where company_id != '5'

select person.name ,company_id, company.name from person join company on person.company_id = company.id

select company.name, count(person.name) as countPerson from company join person on person.company_id = company.id
group by company.name
order by countPerson DESC
LIMIT 1